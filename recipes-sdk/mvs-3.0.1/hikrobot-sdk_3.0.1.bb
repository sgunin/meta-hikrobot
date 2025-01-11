# Copyright (c) 2025, Sergey Gunin
# Released under the MIT license (see LICENSE for the terms)

SUMMARY = "HikVision SDK 3.0.1"
SECTION = "sdk"
LICENSE = "CLOSED"

SRC_URI += ""
SRC_URI:append:aarch64 = " \
	file://MVS-3.0.1_aarch64_20241128.deb \
"
S = "${WORKDIR}"

SYSROOT_DIRS:append = "/opt"

INSANE_SKIP:${PN} += "already-stripped"

FILES:${PN}: += " \
        /opt/mvs \
"
inherit bin_package pkgconfig

install_deb() {
	${STAGING_BINDIR_NATIVE}/dpkg --root=${IMAGE_ROOTFS}/ --admindir=${IMAGE_ROOTFS}/var/lib/dpkg/ -i file://MVS-3.0.1_aarch64_20241128.deb
}

ROOTFS_POSTPROCESS_COMMAND += "install_deb; "

do_package[noexec] = "1"
do_packagedata[noexec] = "1"
do_package_qa[noexec] = "1"
do_configure[noexec] = "1"
do_compile[noexec] = "1"

INHIBIT_PACKAGE_STRIP = "1"
