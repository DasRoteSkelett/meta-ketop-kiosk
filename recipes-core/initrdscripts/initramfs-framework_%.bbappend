FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://plymouthd.sh"

do_install:append() {
		    install -d ${D}/exec.d
		    install -m 755 ${WORKDIR}/plymouthd.sh ${D}/exec.d/
}

FILES:initramfs-module-exec += " \
                	       /exec.d \
	                       /exec.d/plymouthd.sh \
                               "