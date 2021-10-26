FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://defconfig \
	    file://update-ketop.sh \
	    "

RDEPENDS_${PN} += " bash "


do_install:append() {
		    #install helper script
                    install -d ${D}${sbindir}
                    install -m 755 ${WORKDIR}/update-ketop.sh ${D}${sbindir}
}



FILES_${PN} += " \
           /usr/sbin/ \
           /usr/sbin/update-ketop.sh \
"
