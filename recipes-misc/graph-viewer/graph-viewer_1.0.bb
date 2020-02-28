LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=228348db49a2c1d1f4acf2afaea3c2a0"

DEPENDS = " juce-native jucer2cmake-native freetype libx11 xext xinerama gtk+3 "


SRCREV = "55eae637205681874c5c55fa4e60cfddcf267de1"
SRC_URI = "git://github.com/hkarim/JUCE-Graph-Component.git"


S = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE_append = " \
    -DCMAKE_BUILD_TYPE=Release \
    -DCMAKE_INSTALL_PREFIX="${D}/${bindir}" \
    -DCMAKE_VERBOSE_MAKEFILE=TRUE \
    -DJUCE_ROOT=${STAGING_DATADIR_NATIVE}/juce \
    "

do_patch() {
    ${STAGING_BINDIR_NATIVE}/jucer2cmake -i ${S}/graph-viewer.jucer -o ${S}
}

do_install() {
    install -d ${D}${bindir}
    install -m 755 graph-viewer ${D}${bindir}
}

FILES_${PN} = "${bindir}"
