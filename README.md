# Phonymic: Use Your Phone's Mic with Wired Earphones (Experimental)

**Important:** This is an experimental project and may not work reliably on all Android devices due to system limitations.

## Overview

Phonymic is an Android accessibility service designed to enable the use of your phone's built-in microphone while wired earphones are plugged in.

Normally, when wired earphones are connected, Android switches both the audio output and input to the earphones. This can be inconvenient if you want to use the phone's microphone for better audio quality during calls or voice recordings.

**Disclaimer:** This project uses advanced techniques and leverages Android's accessibility features. It may not work consistently across all devices and Android versions due to system security restrictions. It is developed for TECNO CAMON 20 PRO. Future andorid updates may stop the functionality of the app or restict it. 

## Features

- Detects when wired earphones are connected.
- Attempts to switch the audio input to the phone's microphone while maintaining audio output through the earphones.

## Limitations

- **Device Compatibility:** Audio routing behavior varies significantly between different Android devices and manufacturers. The service may not work on all devices.
- **Reliability:** Due to Android’s security limitations, the audio input switching may not be reliable or persistent.
- **Potential Side Effects:** Programmatically altering audio settings might cause unintended side effects on other audio functionalities.

## How to Use

### 1. Clone the Repository:
```bash
git clone https://github.com/ldmoti/Phonymic.git
```

### 2. Open in Android Studio:
Open the project in Android Studio.
### 3. Enable the Service:
Build and install the app on your Android device.
Go to your device’s Settings -> Accessibility -> Installed services.
Find "Phonymic" and enable the service.
### 4. Test:
Connect your wired earphones to the device.
Make a call, record audio, or use any app that utilizes the microphone.
Use Logcat in Android Studio to monitor messages from the service to verify if it detects earphone connections and attempts to switch the audio input.
Contributing
Contributions are welcome! If you have ideas for improvements, bug fixes, or want to expand device compatibility, feel free to open an issue or submit a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
