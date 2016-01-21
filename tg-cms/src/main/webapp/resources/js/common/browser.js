function getBrowserType() {
	var OsObject = "";
	if (navigator.userAgent.indexOf("MSIE") > 0) {
		OsObject = "MSIE";
	}
	if (isFirefox = navigator.userAgent.indexOf("Firefox") > 0) {
		OsObject = "Firefox";
	}
	if (isSafari = navigator.userAgent.indexOf("Safari") > 0
			&& navigator.userAgent.indexOf("Chrome") < 0) {
		OsObject = "Safari";
	}
	if (isCamino = navigator.userAgent.indexOf("Chrome") > 0) {
		OsObject = "Chrome";
	}
	return OsObject;
}