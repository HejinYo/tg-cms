function ajax_download_file(url) {
	if (typeof(ajax_download_file.iframe) == "undefined") {
		var iframe = document.createElement("iframe");
		ajax_download_file.iframe = iframe;
		document.body.appendChild(ajax_download_file.iframe);
	}
	// alert(download_file.iframe);
	ajax_download_file.iframe.src = url;
	ajax_download_file.iframe.style.display = "none";
}