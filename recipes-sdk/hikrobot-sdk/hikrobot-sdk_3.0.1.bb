# Copyright (c) 2025, Sergey Gunin
# Released under the MIT license (see LICENSE for the terms)

SUMMARY = "HikVision SDK 3.0.1"
SECTION = "sdk"
LICENSE = "CLOSED"

SRC_URI:append:aarch64 = " \
	file://lib/aarch64/CommonParameters.ini \
	file://lib/aarch64/libFormatConversion.so \
	file://lib/aarch64/libMvCameraControl.so.4.5.0.3 \
	file://lib/aarch64/libMVGigEVisionSDK.so.4.5.0.3 \
	file://lib/aarch64/libMvSDKVersion.so \
	file://lib/aarch64/libswscale.so \
	file://lib/aarch64/MvProducerGEV.cti \
	file://lib/aarch64/libavutil.so \
	file://lib/aarch64/libMediaProcess.so \
	file://lib/aarch64/libMvCameraControlWrapper.so.4.5.0.1 \
	file://lib/aarch64/libMVRender.so \
	file://lib/aarch64/libMvUsb3vTL.so.4.5.0.3 \
	file://lib/aarch64/libusb-1.0.so.0 \
	file://lib/aarch64/MvProducerU3V.cti \
"

SRC_URI:append:arm = " \
        file://lib/arm/CommonParameters.ini \
        file://lib/arm/libFormatConversion.so \
        file://lib/arm/libMvCameraControl.so.4.5.0.3 \
        file://lib/arm/libMVGigEVisionSDK.so.4.5.0.3 \
        file://lib/arm/libMvSDKVersion.so \
        file://lib/arm/libswscale.so \
        file://lib/arm/MvProducerGEV.cti \
        file://lib/arm/libavutil.so \
        file://lib/arm/libMediaProcess.so \
        file://lib/arm/libMvCameraControlWrapper.so.4.5.0.1 \
        file://lib/arm/libMVRender.so \
        file://lib/arm/libMvUsb3vTL.so.4.5.0.3 \
        file://lib/arm/libusb-1.0.so.0 \
        file://lib/arm/MvProducerU3V.cti \
"

SRC_URI:append:armhf = " \
        file://lib/armhf/CommonParameters.ini \
        file://lib/armhf/libFormatConversion.so \
        file://lib/armhf/libMvCameraControl.so.4.5.0.3 \
        file://lib/armhf/libMVGigEVisionSDK.so.4.5.0.3 \
        file://lib/armhf/libMvSDKVersion.so \
        file://lib/armhf/libswscale.so \
        file://lib/armhf/MvProducerGEV.cti \
        file://lib/armhf/libavutil.so \
        file://lib/armhf/libMediaProcess.so \
        file://lib/armhf/libMvCameraControlWrapper.so.4.5.0.1 \
        file://lib/armhf/libMVRender.so \
        file://lib/armhf/libMvUsb3vTL.so.4.5.0.3 \
        file://lib/armhf/libusb-1.0.so.0 \
        file://lib/armhf/MvProducerU3V.cti \
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
	install -m 0755 ${S}/CLIENT_MVS_Linux_license_notice.txt ${D}/opt/mvs/license/

	install -m 0755 ${S}/CommonParameters.ini ${D}/opt/mvs/lib/
	install -m 0755 ${S}/libFormatConversion.so ${D}/opt/mvs/lib/
	install -m 0755 ${S}/libMvCameraControl.so.4.5.0.3 ${D}/opt/mvs/lib/
	install -m 0755 ${S}/libMVGigEVisionSDK.so.4.5.0.3 ${D}/opt/mvs/lib/
	install -m 0755 ${S}/libMvSDKVersion.so ${D}/opt/mvs/lib/
	install -m 0755 ${S}/libswscale.so ${D}/opt/mvs/lib/
	install -m 0755 ${S}/MvProducerGEV.cti ${D}/opt/mvs/lib/
	install -m 0755 ${S}/libavutil.so ${D}/opt/mvs/lib/
	install -m 0755 ${S}/libMediaProcess.so ${D}/opt/mvs/lib/
	install -m 0755 ${S}/libMvCameraControlWrapper.so.4.5.0.1 ${D}/opt/mvs/lib/
	install -m 0755 ${S}/libMVRender.so ${D}/opt/mvs/lib/
	install -m 0755 ${S}/libMvUsb3vTL.so.4.5.0.3 ${D}/opt/mvs/lib/
	install -m 0755 ${S}/libusb-1.0.so.0 ${D}/opt/mvs/lib/
	install -m 0755 ${S}/MvProducerU3V.cti ${D}/opt/mvs/lib/

	install -m 0755 ${S}/CameraParams.h ${D}/opt/mvs/include/
	install -m 0755 ${S}/MvCameraControl.h ${D}/opt/mvs/include/
	install -m 0755 ${S}/MvErrorDefine.h ${D}/opt/mvs/include/
	install -m 0755 ${S}/MvISPErrorDefine.h ${D}/opt/mvs/include/
	install -m 0755 ${S}/MvObsoleteInterfaces.h ${D}/opt/mvs/include/
	install -m 0755 ${S}/ObsoleteCamParams.h ${D}/opt/mvs/include/
	install -m 0755 ${S}/PixelType.h ${D}/opt/mvs/include/

	install -m 0755 ${S}/hikrobot.sh ${D}${sysconfdir}/profile.d/

	cd ${D}${libdir}
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
