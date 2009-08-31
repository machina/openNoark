<script type="application/x-javascript" src="chrome://messenger/content/messengercompose/MsgComposeCommands.js"/>


function catchDoc()
{
	var attachmentList = document.getElementById('attachmentList');
  var selectedAttachments = attachmentList.selectedItems;

  if (selectedAttachments.length != 1)

     alert(" Select an Attachment to Rename ");

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
			var reg = registerRegistration(req, params.out.folderId);
			/*
			var children = reg.childNodes;
			var doc = "";
			for (i=0;i<children.length;i++){
				alert(children[i].tagName);
				var sub = children[i].childNodes
				for (j=0;j<sub.length;j++){
					alert(sub[j].tagName);
				}

			}*/
			var regId = reg.getElementsByTagName('systemid')[0].textContent;
			alert("regId: "+regId);
			var docobj =  registerDocObject(req, regId );
			docobj = docobj.getElementsByTagName('systemid')[0].textContent;
			archiveDoc(req, docobj, bytes);
			alert("ferdig");
    
}



function login(req){
	req.open("GET", "http://localhost:8080/openNoark/auth/signIn?username=admin&password=admin", false);
	//req.setRequestHeader('Accept','text/xml')

	req.send(null);
}

function getFolders(req){
	req.open("GET", "http://localhost:8080/openNoark/basismappe/list", false);
  req.setRequestHeader("Content-Type", "text/json");
	req.setRequestHeader('Accept','text/json'); 
  req.send(null);
	return req.responseText;
}

function registerRegistration(req, folderId){
	//alert(folderId);
	var reg = '<?xml version=\"1.0\"?>\n<ForenkletRegistrering>'
						+'	<registreringstype>dilldall</registreringstype>'
						+'	<opprettetdato>02-02-2002</opprettetdato>'
						+'	<opprettetav>meg</opprettetav>'
						+'	<arkivertdato>02-02-2002</arkivertdato>'
						+'	<arkivertav>deg</arkivertav>'
						+'	<mappe_id>'+folderId+'</mappe_id>'
						+'</ForenkletRegistrering>';
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
						+ '<format>?</format>'
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
	var b64 = btoa(doc)
	//req.setRequestHeader("Content-Length", b64.length);  
	req.send(b64);  
	alert(req.responseText);		
}

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
	alert("bstream.available "+bstream.available());
	//while(bstream.available() <= 0){  }
	var size = 0;
	var file_data = "";
	alert("filesize: "+fileSize);
	while(file_data.length < fileSize) { 
    file_data += bstream.readBytes(bstream.available()); 
  }
	alert("data  length"+file_data.length)
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
