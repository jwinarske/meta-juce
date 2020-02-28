SUMMARY = ""
LICENSE = "GPL"
LIC_FILES_CHKSUM = "file://LICENSE;md5=228348db49a2c1d1f4acf2afaea3c2a0"

DEPENDS = " projucer-native juce-native jucer2cmake-native freetype libx11 xext xinerama gtk+3 webkitgtk alsa-lib "

SRCREV = "master"
SRC_URI = "git://github.com/Tracktion/tracktion_engine.git"
           

S = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE_append = " \
    -DCMAKE_BUILD_TYPE=Release \
    -DCMAKE_INSTALL_PREFIX="${D}/${bindir}" \
    -DCMAKE_VERBOSE_MAKEFILE=TRUE \
    -DJUCE_ROOT=${STAGING_DATADIR_NATIVE}/juce \
    "

do_patch() {

    ${STAGING_BINDIR_NATIVE}/Projucer \
        --create-project-from-pip \
        ${S}/examples/TestRunner.h \
        ${S}/examples/projects \
        ${S}/juce/modules \
        ${S}/modules

    ${STAGING_BINDIR_NATIVE}/Projucer \
        --resave \
        ${S}/examples/projects/TestRunner/TestRunner.jucer

    ${STAGING_BINDIR_NATIVE}/jucer2cmake \
        -i ${S}/TestRunner.jucer -o ${S}
}

do_install() {
    install -d ${D}${bindir}
    install -m 755 TestRunner ${D}${bindir}
}

FILES_${PN} = "${bindir}/TestRunner"

