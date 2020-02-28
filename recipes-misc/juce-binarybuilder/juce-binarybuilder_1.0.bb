SUMMARY = "BinaryBuilder is used to encode folder of resources into a cpp file"
LICENSE = "ISC"

DEPENDS = " juce-native curl"

inherit cmake

S = "${STAGING_DATADIR_NATIVE}/juce/extras/BinaryBuilder"

EXTRA_OECMAKE_append = " \
    -DCMAKE_BUILD_TYPE=Release \
    -DCMAKE_INSTALL_PREFIX="${D}/${bindir}" \
    -DCMAKE_VERBOSE_MAKEFILE=TRUE \
    -DJUCE_ROOT=${STAGING_DATADIR_NATIVE}/juce \
    "

do_install() {
    install -d ${D}${bindir}
    install -m 755 BinaryBuilder ${D}${bindir}
}

FILES_${PN} = "${bindir}"

BBCLASSEXTEND += "native nativesdk"

