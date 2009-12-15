<script type="application/x-javascript" src="chrome://messenger/content/messengercompose/MsgComposeCommands.js"/>


function catchMail(){
	var msgPane = document.getElementById("messagepane");
	var content = "<html>"+ msgPane.contentDocument.getElementsByTagName("html")[0].innerHTML + "</html>";
	
	var req = new XMLHttpRequest();
  login(req);
	var classTxt = getClasses(req);
	var archivePartsTxt = getArchiveParts(req);

	//alert(classTxt);
	var params = {inn:{regtype: "dilldall", classTxt: classTxt, archivePartsTxt: archivePartsTxt }, out:null};
	
	window.openDialog("chrome://opennoark/content/opennoarkmaildiag.xul", "",
   "chrome, dialog, modal, resizable=yes", params).focus();
	
	var reg = registerRegistration(req, null, params.out.klasseId, params.out.archiveId );
	var regId = reg.getElementsByTagName('systemID')[0].textContent;
	var docobj =  registerDocObject(req, regId );
  docobj = docobj.getElementsByTagName('systemID')[0].textContent;
  archiveDoc(req, docobj, content);
	alert("ferdig");
}

function catchDoc()
{
	var attachmentList = document.getElementById('attachmentList');
  var selectedAttachments = attachmentList.selectedItems;

  if (selectedAttachments.length != 1)

     alert(" Select an Attachment");

  else
    {
			var item = selectedAttachments[0];
			saveAndReadAttachment(item.attachment);
		}

}

function catchDoc2(bytes){
			var req = new XMLHttpRequest();
			login(req);
			var folderTxt = getFolders(req);
					//alert(folderTxt);

	    
  	  //var attachmentName = {value: item.attachment.name};
			var params = {inn:{regtype: "dilldall", folderTxt: folderTxt}, out:null};
			window.openDialog("chrome://opennoark/content/opennoarkdiag.xul", "", 
			"chrome, dialog, modal, resizable=yes", params).focus();
			//alert(bytes);
			//alert(params.out);
			var reg = registerRegistration(req, params.out.folderId, null);
			var regId = reg.getElementsByTagName('systemid')[0].textContent;
			//alert("regId: "+regId);
			var docobj =  registerDocObject(req, regId );
			docobj = docobj.getElementsByTagName('systemid')[0].textContent;
			archiveDoc(req, docobj, bytes);
			//alert("ferdig");
    
}



function login(req){
	req.open("GET", "http://localhost:8080/openNoark/auth/signIn?username=admin&password=admin", false);
	//req.setRequestHeader('Accept','text/xml')

	req.send(null);
}

function getArchiveParts(req){
	req.open("GET", "http://localhost:8080/openNoark/arkivdel/list", false);
  req.setRequestHeader("Content-Type", "text/json");
	req.setRequestHeader('Accept','text/json'); 
  req.send(null);
	return req.responseText;
}


function getFolders(req){
	req.open("GET", "http://localhost:8080/openNoark/basismappe/list", false);
  req.setRequestHeader("Content-Type", "text/json");
	req.setRequestHeader('Accept','text/json'); 
  req.send(null);
	return req.responseText;
}

function getClasses(req){
	req.open("GET", "http://localhost:8080/openNoark/klasse/list", false);
  req.setRequestHeader("Content-Type", "text/json");
	req.setRequestHeader('Accept','text/json'); 
  req.send(null);
	return req.responseText;
}


function registerRegistration(req, folderId, classId, archivepart_id){
	//alert(folderId);
	var reg = '<?xml version=\"1.0\"?>\n<ForenkletRegistrering>'
						+'	<registreringstype>dilldall</registreringstype>'
						+'	<opprettetdato>02-02-2002</opprettetdato>'
						+'	<opprettetav>meg</opprettetav>'
						+'	<arkivertdato>02-02-2002</arkivertdato>'
						+'	<arkivertav>deg</arkivertav>';
	if(folderId != null){
						reg = reg+'	<mappe_id>'+folderId+'</mappe_id>';
	}
	if(classId != null)  {
		reg = reg+' <klasse_id>'+classId+'</klasse_id>';
	}
	if(archivepart_id != null){
		reg = reg + ' <arkivdel_id>'+archivepart_id+'</arkivdel_id>'
	}
	
 	reg = reg + '</ForenkletRegistrering>';
	//alert(reg);
	req.open("POST", "http://localhost:8080/openNoark/remote/forenkletRegistrering", false);
	req.setRequestHeader("Content-Type", "text/xml");
	req.setRequestHeader('Accept','text/json');
	req.send(reg);
	//alert(req.responseText);
	return req.responseXML;
}

function registerDocObject(req, regId){
  //alert(folderId);
  var reg = '<?xml version=\"1.0\"?>\n<dokumentobjekt>'
						+ '<versjonsnummer>1</versjonsnummer>'
						+ '<variantformat>?</variantformat>'
						+ '<format>text/html</format>'
						+ '<formatdetaljer>?</formatdetaljer>'
						+ '<opprettetdato>02-02-2002</opprettetdato>'
            + '<opprettetav>meg</opprettetav>'
						+ '<referansedokumentfil>?</referansedokumentfil>'
						+ '<referanseregistrering>'+regId+'</referanseregistrering>'
						+ '<filstørrelse>-1</filstørrelse>'
						+ '<sjekksumalgoritme>none</sjekksumalgoritme>'
						+ '<sjekksumdokument>?</sjekksumdokument>'
						+ '<variantformat>?</variantformat>'
						+ '<versjonsnummer>?</versjonsnummer>'
            +'</dokumentobjekt>';
  req.open("POST", "http://localhost:8080/openNoark/remote/dokumentobjekt", false);
  req.setRequestHeader("Content-Type", "text/xml");
	//req.setRequestHeader('Accept','text/json');
  req.send(reg);
  //alert(req.responseText);
  return req.responseXML;
}

function archiveDoc(req, docObjId, doc){
	req.open("POST", "http://localhost:8080/openNoark/fileStoage/save/"+docObjId, false);
	var b64 = btoa(doc);
	//req.setRequestHeader("Content-Length", b64.length);  
	req.send(b64);  
	//alert(req.responseText);		
}


var TMP_DIR = "/tmp/";

//Stolen shamelessly readonly attachments and https://developer.mozilla.org/en/Code_snippets/File_I%2F%2FO
function saveAndReadAttachment(anAttachment) {
   // get a handle to the temporary folder
   var target = Components.classes["@mozilla.org/file/local;1"].
                 createInstance(Components.interfaces.nsILocalFile);
   target.initWithPath(TMP_DIR + "foo");

   // save the attachment to the folder
	
   var savedFile = messenger.saveAttachmentToFolder(anAttachment.contentType,
                             anAttachment.url,
                             getFileName(anAttachment.displayName),
                             anAttachment.messageUri, target);
  setTimeout(saveAndReadSavedFile, 5000, savedFile);
	
}

function saveAndReadSavedFile(savedFile) {
	var fileSize = savedFile.fileSize

	var istream = Components.classes["@mozilla.org/network/file-input-stream;1"].
                        createInstance(Components.interfaces.nsIFileInputStream);
	istream.init(savedFile, -1, -1, false);

	var bstream = Components.classes["@mozilla.org/binaryinputstream;1"].
                        createInstance(Components.interfaces.nsIBinaryInputStream);
	bstream.setInputStream(istream);
	//bstream.available();
	//busyWait(10000);
	//alert("bstream.available "+bstream.available());
	//while(bstream.available() <= 0){  }
	var size = 0;
	var file_data = "";
	//alert("filesize: "+fileSize);
	while(file_data.length < fileSize) { 
    file_data += bstream.readBytes(bstream.available()); 
  }
	//alert("data  length"+file_data.length)
	catchDoc2(file_data);
	//var bytes = bstream.readBytes(bstream.available());
	//return bytes

} // saveAttachment


function getFileName(baseName) {

   // baseName = encodeURIComponent(baseName);
   var newName = baseName;

   // create a local file handler to check for file existence
   var target = Components.classes["@mozilla.org/file/local;1"].
                 createInstance(Components.interfaces.nsILocalFile);
   target.initWithPath(TMP_DIR + newName);

   count = 0;
   while (target.exists()) {
      count++;

      newName = count + "_" + baseName;
      target.initWithPath(TMP_DIR + newName);
   } // while the file name already exists

   return newName;

} // getFileName


function busyWait(millis){
	var date = new Date();
	var curDate = null;

	do { curDate = new Date(); }
	while(curDate-date < millis);
}



/*****************************************************************
Called from xul
******************************************************************/

// Called once when the dialog displays
function onLoad() {
  // Use the arguments passed to us by the caller
  document.getElementById("regtype").value = window.arguments[0].inn.regtype;

	var folderTxt = window.arguments[0].inn.folderTxt;
	var menulist = document.getElementById("mappeliste");
	//alert(folderTxt);
	var folders = eval(folderTxt);
	//alert(folders);
	for(folder in folders){
		var item = document.createElement('menuitem');
		item.setAttribute('label',folders[folder].tittel);
		item.setAttribute('value',folders[folder].id);
		menulist.appendChild(item);
	}
}

// Called once if and only if the user clicks OK
function onOK() {
   // Return the changed arguments.
   // Notice if user clicks cancel, window.arguments[0].out remains null
   // because this function is never called
		//alert("folderlist:"+document.getElementById("folderlist"));
		//alert("selectedItem"+document.getElementById("folderlist").selectedIndex);
		//alert("selectedItem"+document.getElementById("folderlist").selectedItem);
   window.arguments[0].out = {name:document.getElementById("regtype").value,
				folderId: document.getElementById("folderlist").selectedItem.value};
   return true;
}


function onLoadMail() {
	document.getElementById("regtype").value = window.arguments[0].inn.regtype;
	var classlist = document.getElementById("klasseliste");
	var archivePartList = document.getElementById("arkivdelliste");	

	var classTxt = window.arguments[0].inn.classTxt;
	var classes = eval(classTxt);
	//alert(classes);
	for(klass in classes){
		var item = document.createElement('menuitem');
		item.setAttribute('label',classes[klass].fullId);
    item.setAttribute('value',classes[klass].id);
    classlist.appendChild(item);
	}

	var archivePartsTxt = window.arguments[0].inn.archivePartsTxt;
	//alert(archivePartsTxt);
	var archiveParts = eval(archivePartsTxt);

	for(part in archiveParts){
		var item = document.createElement('menuitem');
		item.setAttribute('label',archiveParts[part].tittel);
    item.setAttribute('value',archiveParts[part].id);
    archivePartList.appendChild(item);
	}
	
}


function onMailOK() {	
	window.arguments[0].out = { name:document.getElementById("regtype").value,
															klasseId: document.getElementById("klassemenylist").selectedItem.value,
															archiveId: document.getElementById("arkivdelmenylist").selectedItem.value};
	return true;
}
