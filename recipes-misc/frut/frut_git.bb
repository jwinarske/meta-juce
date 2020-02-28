LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"

SRCREV = "aeafdea2813da65791e33bee4a9595b5a5c11443"
SRC_URI = "git://github.com/jwinarske/FRUT.git;branch=yocto_linux"

DEPENDS = " juce-native freetype-native libx11-native xext-native"

S = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE_append = " \
    -DJUCE5_LICENSE=GPL \
    -DCMAKE_BUILD_TYPE=Release \
    -DJUCE_ROOT=${datadir}/JUCE \
    -DCMAKE_VERBOSE_MAKEFILE=TRUE \
    -DCMAKE_INSTALL_PREFIX=${D}/${datadir} \
    "

do_install() {
    install -d ${D}${datadir}/FRUT
    cmake -P cmake_install.cmake
}

FILES_${PN}  = "${datadir}/FRUT/*"

BBCLASSEXTEND += "native nativesdk"
