<script type="application/x-javascript" src="chrome://messenger/content/messengercompose/MsgComposeCommands.js"/>


function catchDoc()
{
	var attachmentList = document.getElementById('attachmentList');
  var selectedAttachments = attachmentList.selectedItems;

  if (selectedAttachments.length != 1)

     alert(" Select an Attachment to Rename ");

  else
    {
			var req = new XMLHttpRequest();
			login(req);
			var folderTxt = getFolders(req);
			//alert(folderTxt);

	    var item = selectedAttachments[0]

  	  var attachmentName = {value: item.attachment.name};
			var params = {inn:{regtype: "dilldall", folderTxt: folderTxt}, out:null};
			window.openDialog("chrome://opennoark/content/opennoarkdiag.xul", "", 
			"chrome, dialog, modal, resizable=yes", params).focus();
			alert(params.out);
			registerRegistration(req, params.out.folderId);
    }
}



function login(req){
	req.open("GET", "http://localhost:8080/openNoark/auth/signIn?username=admin&password=admin", false);
	//req.setRequestHeader('Accept','text/xml')

	req.send(null);
}

function getFolders(req){
	req.open("GET", "http://localhost:8080/openNoark/basismappe/list", false);
  req.setRequestHeader("Content-Type", "text/json");
	req.setRequestHeader('Accept','text/xml'); 
  req.send(null);
	return req.responseText;
}

function registerRegistration(req, folderId){
	alert(folderId);
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
	req.send(reg);
	//alert(req.responseText);
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
		alert("folderlist:"+document.getElementById("folderlist"));
		alert("selectedItem"+document.getElementById("folderlist").selectedIndex);
		alert("selectedItem"+document.getElementById("folderlist").selectedItem);
   window.arguments[0].out = {name:document.getElementById("regtype").value,
				folderId: document.getElementById("folderlist").selectedItem.value};
   return true;
}


