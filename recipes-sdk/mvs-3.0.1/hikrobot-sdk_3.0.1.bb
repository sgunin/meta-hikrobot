# Copyright (c) 2025, Sergey Gunin
# Released under the MIT license (see LICENSE for the terms)

SUMMARY = "HikVision SDK 3.0.1"
SECTION = "sdk"
LICENSE = "CLOSED"

SRC_URI:append:aarch64 = " \
        file://MVS.tar.gz;subdir=mvs \
"
S = "${WORKDIR}"

SYSROOT_DIRS:append = "/opt/mvs"

FILES:${PN} += " \
        /opt/mvs \
"

INSANE_SKIP:${PN} += "already-stripped arch split-strip"

do_install:append() {
        install -d ${D}/opt/mvs/lib
        cp -r ${WORKDIR}/mvs/bin ${D}/opt/mvs/
        cp -r ${WORKDIR}/mvs/include ${D}/opt/mvs/
        cp -r ${WORKDIR}/mvs/license ${D}/opt/mvs/
        cp -r ${WORKDIR}/mvs/lib/aarch64 ${D}/opt/mvs/lib
        cp ${WORKDIR}/mvs/ReleaseNote_EN.txt ${D}/opt/mvs/
}

do_package_qa[noexec] = "1"

EXCLUDE_FROM_SHLIBS = "1"

# Disables the files in your package from being split into run-time and debug components
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"

# Disabled the system from attempting to strip the run-time components of debug information
INHIBIT_PACKAGE_STRIP = "1"
