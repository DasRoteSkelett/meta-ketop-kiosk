FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://chromium.service"

inherit systemd

SYSTEMD_SERVICE:${PN} = "chromium.service"

do_install:append() {
        install -d ${D}${systemd_unitdir}/system
	install -m 644 ${WORKDIR}/chromium.service ${D}${systemd_unitdir}/system/
}	