SUMMARY = "The JUCE cross-platform C++ framework"
LICENSE = "ISC"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=a20f91622a47d4e4af9340d5d3f1a2d8"

DEPENDS_append_class = " juce-native jucer2cmake-native curl"

SRCREV = "1e71c07a492f01022f9064560c95c2bcd938847c"
SRC_URI = "git://github.com/WeAreROLI/JUCE.git"

S = "${WORKDIR}/git"


do_install() {

    ${STAGING_BINDIR_NATIVE}/jucer2cmake \
        -i ${WORKDIR}/git/extras/AudioPerformanceTest/AudioPerformanceTest.jucer

    ${STAGING_BINDIR_NATIVE}/jucer2cmake \
        -i ${WORKDIR}/git/extras/AudioPluginHost/AudioPluginHost.jucer

    ${STAGING_BINDIR_NATIVE}/jucer2cmake \
        -i ${WORKDIR}/git/extras/BinaryBuilder/BinaryBuilder.jucer

    ${STAGING_BINDIR_NATIVE}/jucer2cmake \
        -i ${WORKDIR}/git/extras/NetworkGraphicsDemo/NetworkGraphicsDemo.jucer

    ${STAGING_BINDIR_NATIVE}/jucer2cmake \
        -i ${WORKDIR}/git/juce/extras/Projucer/Projucer.jucer

    ${STAGING_BINDIR_NATIVE}/jucer2cmake \
        -i ${WORKDIR}/git/extras/UnitTestRunner/UnitTestRunner.jucer

    ${STAGING_BINDIR_NATIVE}/jucer2cmake \
        -i ${WORKDIR}/git/examples/DemoRunner/DemoRunner.jucer

    install -d ${D}${datadir}/juce
    cp -r ${WORKDIR}/git/* ${D}${datadir}/juce
}

do_install[depends] += " \
    jucer2cmake-native:do_populate_sysroot \
    "


FILES_${PN} = "${datadir}/juce/*"

BBCLASSEXTEND += "native nativesdk"

