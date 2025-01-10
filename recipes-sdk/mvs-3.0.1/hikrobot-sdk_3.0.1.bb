# Copyright (c) 2025, Sergey Gunin
# Released under the MIT license (see LICENSE for the terms)

SUMMARY = "HikVision SDK 3.0.1"
LICENSE = "MIT"

COMPATIBLE_MACHINE = "^$"
COMPATIBLE_MACHINE:arch64 = "^(aarch64)$"

FILESEXTRAPATHS:prepend:aarch64 := "${THISDIR}/files:"

SRC_URI = " \
	file://MVS.tar.gz \
"

S = "${WORKDIR}"

SYSROOT_DIRS:append = " /opt"

do_unpack() {
	tar -xzf ${WORKDIR}/MVS.tar.gz -C ${WORKDIR}
}

do_install() {
	install -d ${D}/opt/mvs
	cp -r ${WORKDIR}/MVS/* ${D}/opt/mvs
}

FILES:${PN}: += " \
	/opt/mvs \
"
