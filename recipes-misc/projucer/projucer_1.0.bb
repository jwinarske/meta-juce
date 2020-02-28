SUMMARY = "Projucer"
LICENSE = "ISC"

DEPENDS = " juce-native freetype gtk+3 curl webkitgtk libx11 xext xinerama  "

inherit cmake

S = "${STAGING_DATADIR_NATIVE}/juce/extras/Projucer"

EXTRA_OECMAKE_append = " \
    -DCMAKE_BUILD_TYPE=Release \
    -DCMAKE_INSTALL_PREFIX="${D}/${bindir}" \
    -DCMAKE_VERBOSE_MAKEFILE=TRUE \
    -DJUCE_ROOT=${STAGING_DATADIR_NATIVE}/juce \
    "

do_install() {
    install -d ${D}${bindir}
    install -m 755 Projucer ${D}${bindir}
}

FILES_${PN} = "${bindir}/Projucer"

