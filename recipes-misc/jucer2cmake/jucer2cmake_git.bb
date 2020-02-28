LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2e76a574376349f1d951776c9d38735a"

SRCREV = "master"
SRC_URI = "git://github.com/jwinarske/jucer2cmake.git"

S = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE_append = " \
    -DCMAKE_VERBOSE_MAKEFILE=TRUE \
    -DCMAKE_INSTALL_PREFIX=${D}/${bindir} \
    "

do_install() {
    install -d ${D}${bindir}
    install -m 755 jucer2cmake ${D}${bindir}
}

FILES_${PN}  = "${bindir}/jucer2cmake"

BBCLASSEXTEND += "native nativesdk"
