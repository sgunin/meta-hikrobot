# Copyright (c) 2025, Sergey Gunin
# Released under the MIT license (see LICENSE for the terms)

DESCRIPTION = "Hikvision configuration files for udev"
LICENSE = "CLOSED"

SRC_URI = " \
        file://80-hikvision-sdk-drivers.rules \
"

S = "${WORKDIR}"

do_install() {
        install -d ${D}${nonarch_base_libdir}/udev/rules.d
        install -m 0644 ${WORKDIR}/80-hikvision-sdk-drivers.rules ${D}${nonarch_base_libdir}/udev/rules.d/80-hikvision-sdk-drivers.rules
}
