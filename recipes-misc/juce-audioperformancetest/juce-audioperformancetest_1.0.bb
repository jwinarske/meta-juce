SUMMARY = "AudioPerformanceTest based on the JUCE cross-platform C++ framework"
LICENSE = "ISC"

DEPENDS = " juce-native freetype libx11 xext xinerama gtk+3 webkitgtk alsa-lib"

inherit cmake

S = "${STAGING_DATADIR_NATIVE}/juce/extras/AudioPerformanceTest"

EXTRA_OECMAKE_append = " \
    -DCMAKE_BUILD_TYPE=Release \
    -DCMAKE_INSTALL_PREFIX="${D}/${bindir}" \
    -DCMAKE_VERBOSE_MAKEFILE=TRUE \
    -DJUCE_ROOT=${STAGING_DATADIR_NATIVE}/juce \    
    "

do_install() {
    install -d ${D}${bindir}
    install -m 755 AudioPerformanceTest ${D}${bindir}
}

FILES_${PN} = "${bindir}"

