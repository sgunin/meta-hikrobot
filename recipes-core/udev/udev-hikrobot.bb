# Copyright (c) 2025, Sergey Gunin
# Released under the MIT license (see LICENSE for the terms)

DESCRIPTION = "Hikvision configuration files for udev"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = "file://80-hikvision-sdk.rules"

FILES_${PN} += "${sysconfdir}/udev/rules.d/80-hikvision-sdk.rules"

S = "${WORKDIR}"

do_install() {
        install -d ${D}${sysconfdir}/udev/rules.d
        install -m 0644 ${WORKDIR}/80-hikvision-sdk.rules ${D}${sysconfdir}/udev/rules.d/80-hikvision-sdk.rules
}
