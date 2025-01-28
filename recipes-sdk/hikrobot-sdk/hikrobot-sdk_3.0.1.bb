# Copyright (c) 2025, Sergey Gunin
# Released under the MIT license (see LICENSE for the terms)

SUMMARY = "HikVision SDK 3.0.1"
SECTION = "sdk"
LICENSE = "CLOSED"

SRC_URI:append:aarch64 = " \
	file://lib/aarch64/CommonParameters.ini;subdir=lib \
	file://lib/aarch64/libFormatConversion.so;subdir=lib \
	file://lib/aarch64/libMvCameraControl.so.4.5.0.3;subdir=lib \
	file://lib/aarch64/libMVGigEVisionSDK.so.4.5.0.3;subdir=lib \
	file://lib/aarch64/libMvSDKVersion.so;subdir=lib \
	file://lib/aarch64/libswscale.so;subdir=lib \
	file://lib/aarch64/MvProducerGEV.cti;subdir=lib \
	file://lib/aarch64/libavutil.so;subdir=lib \
	file://lib/aarch64/libMediaProcess.so;subdir=lib \
	file://lib/aarch64/libMvCameraControlWrapper.so.4.5.0.1;subdir=lib \
	file://lib/aarch64/libMVRender.so;subdir=lib \
	file://lib/aarch64/libMvUsb3vTL.so.4.5.0.3;subdir=lib \
	file://lib/aarch64/libusb-1.0.so.0;subdir=lib \
	file://lib/aarch64/MvProducerU3V.cti;subdir=lib \
"

SRC_URI:append:arm = " \
        file://lib/arm/CommonParameters.ini;subdir=lib \
        file://lib/arm/libFormatConversion.so;subdir=lib \
        file://lib/arm/libMvCameraControl.so.4.5.0.3;subdir=lib \
        file://lib/arm/libMVGigEVisionSDK.so.4.5.0.3;subdir=lib \
        file://lib/arm/libMvSDKVersion.so;subdir=lib \
        file://lib/arm/libswscale.so;subdir=lib \
        file://lib/arm/MvProducerGEV.cti;subdir=lib \
        file://lib/arm/libavutil.so;subdir=lib \
        file://lib/arm/libMediaProcess.so;subdir=lib \
        file://lib/arm/libMvCameraControlWrapper.so.4.5.0.1;subdir=lib \
        file://lib/arm/libMVRender.so;subdir=lib \
        file://lib/arm/libMvUsb3vTL.so.4.5.0.3;subdir=lib \
        file://lib/arm/libusb-1.0.so.0;subdir=lib \
        file://lib/arm/MvProducerU3V.cti;subdir=lib \
"

SRC_URI:append:armhf = " \
        file://lib/armhf/CommonParameters.ini;subdir=lib \
        file://lib/armhf/libFormatConversion.so;subdir=lib \
        file://lib/armhf/libMvCameraControl.so.4.5.0.3;subdir=lib \
        file://lib/armhf/libMVGigEVisionSDK.so.4.5.0.3;subdir=lib \
        file://lib/armhf/libMvSDKVersion.so;subdir=lib \
        file://lib/armhf/libswscale.so;subdir=lib \
        file://lib/armhf/MvProducerGEV.cti;subdir=lib \
        file://lib/armhf/libavutil.so;subdir=lib \
        file://lib/armhf/libMediaProcess.so;subdir=lib \
        file://lib/armhf/libMvCameraControlWrapper.so.4.5.0.1;subdir=lib \
        file://lib/armhf/libMVRender.so;subdir=lib \
        file://lib/armhf/libMvUsb3vTL.so.4.5.0.3;subdir=lib \
        file://lib/armhf/libusb-1.0.so.0;subdir=lib \
        file://lib/armhf/MvProducerU3V.cti;subdir=lib \
"

SRC_URI:append = " \
	file://include/CameraParams.h \
	file://include/MvCameraControl.h \
	file://include/MvErrorDefine.h \
	file://include/MvISPErrorDefine.h \
	file://include/MvObsoleteInterfaces.h \
	file://include/ObsoleteCamParams.h \
	file://include/PixelType.h \
	file://license/CLIENT_MVS_Linux_license_notice.txt \
	file://ReleaseNote_EN.txt \
	file://hikrobot.sh \
"

S = "${WORKDIR}"

INSANE_SKIP:${PN} += "dev-so shebang-size already-stripped ldflags"

DEPENDS:append = " bash"
RDEPENDS:${PN} = "bash"

do_install:append() {
        install -d ${D}/opt/mvs/
	install -d ${D}/opt/mvs/lib
	install -d ${D}/opt/mvs/include
	install -d ${D}/opt/mvs/license
	install -d ${D}${sysconfdir}/profile.d/

	install -m 0755 ${S}/ReleaseNote_EN.txt ${D}/opt/mvs/
	install -m 0755 ${S}/license/CLIENT_MVS_Linux_license_notice.txt ${D}/opt/mvs/license/

	install -m 0755 ${S}/lib/CommonParameters.ini ${D}/opt/mvs/lib/
	install -m 0755 ${S}/lib/libFormatConversion.so ${D}/opt/mvs/lib/
	install -m 0755 ${S}/lib/libMvCameraControl.so.4.5.0.3 ${D}/opt/mvs/lib/
	install -m 0755 ${S}/lib/libMVGigEVisionSDK.so.4.5.0.3 ${D}/opt/mvs/lib/
	install -m 0755 ${S}/lib/libMvSDKVersion.so ${D}/opt/mvs/lib/
	install -m 0755 ${S}/lib/libswscale.so ${D}/opt/mvs/lib/
	install -m 0755 ${S}/lib/MvProducerGEV.cti ${D}/opt/mvs/lib/
	install -m 0755 ${S}/lib/libavutil.so ${D}/opt/mvs/lib/
	install -m 0755 ${S}/lib/libMediaProcess.so ${D}/opt/mvs/lib/
	install -m 0755 ${S}/lib/libMvCameraControlWrapper.so.4.5.0.1 ${D}/opt/mvs/lib/
	install -m 0755 ${S}/lib/libMVRender.so ${D}/opt/mvs/lib/
	install -m 0755 ${S}/lib/libMvUsb3vTL.so.4.5.0.3 ${D}/opt/mvs/lib/
	install -m 0755 ${S}/lib/libusb-1.0.so.0 ${D}/opt/mvs/lib/
	install -m 0755 ${S}/lib/MvProducerU3V.cti ${D}/opt/mvs/lib/

	install -m 0755 ${S}/include/CameraParams.h ${D}/opt/mvs/include/
	install -m 0755 ${S}/include/MvCameraControl.h ${D}/opt/mvs/include/
	install -m 0755 ${S}/include/MvErrorDefine.h ${D}/opt/mvs/include/
	install -m 0755 ${S}/include/MvISPErrorDefine.h ${D}/opt/mvs/include/
	install -m 0755 ${S}/include/MvObsoleteInterfaces.h ${D}/opt/mvs/include/
	install -m 0755 ${S}/include/ObsoleteCamParams.h ${D}/opt/mvs/include/
	install -m 0755 ${S}/include/PixelType.h ${D}/opt/mvs/include/

	install -m 0755 ${S}/hikrobot.sh ${D}${sysconfdir}/profile.d/

	cd ${D}/opt/mvs/lib
	ln -sf libMvCameraControl.so.4.5.0.3 libMvCameraControl.so
	ln -sf libMvCameraControlWrapper.so.4.5.0.1 libMvCameraControlWrapper.so
	ln -sf libMVGigEVisionSDK.so.4.5.0.3 libMVGigEVisionSDK.so
	ln -sf libMvUsb3vTL.so.4.5.0.3 libMvUsb3vTL.so
	cd -
}

do_package_qa[noexec] = "1"

FILES:${PN} += " \
        /opt/mvs/ReleaseNote_EN.txt \
	/opt/mvs/lib \
	/opt/mvs/license \
	${D}${sysconfdir}/profile.d \
"

FILES:${PN}-dev += " \
	/opt/mvs/include \
"
