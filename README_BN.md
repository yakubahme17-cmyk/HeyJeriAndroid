# Hey Jeri — Android starter project

এটি Hey Jeri-এর একটি প্রাথমিক Android Studio source project।

## কী আছে
- Start/Stop বোতাম
- মাইক্রোফোন পারমিশন
- foreground microphone service ও স্থায়ী notification
- Android SpeechRecognizer দিয়ে “Hey Jeri” শনাক্ত করার চেষ্টা
- Android TextToSpeech দিয়ে বাংলা উত্তর
- সময়, তারিখ ও কয়েকটি সাধারণ কথার সীমিত উত্তর

## গুরুত্বপূর্ণ সীমাবদ্ধতা
- এটি এখনো পূর্ণ AI assistant নয়; ইন্টারনেট-ভিত্তিক AI API যুক্ত করা নেই।
- Android-এর built-in SpeechRecognizer সাধারণত সিস্টেমের speech service/ইন্টারনেট ব্যবহার করতে পারে। এটি dedicated offline wake-word engine নয়।
- “Hey Jeri” সব ফোনে সব সময় শনাক্ত হবে এমন নিশ্চয়তা নেই। Android version, battery optimization, vendor restrictions, language pack ও speech service-এর ওপর নির্ভর করে।
- Android 14+ এ microphone foreground service চালুর নিয়ম কড়া। ব্যবহারকারীকে অ্যাপ খুলে Start চাপতে হবে; ফোন restart-এর পর নিজে থেকে microphone চালু করার চেষ্টা এই starter project করে না।
- বাংলা TTS voice ফোনে ইনস্টল/সমর্থিত না হলে Android Settings থেকে Bengali text-to-speech voice ইনস্টল করুন।
- নিরাপত্তার জন্য API key APK-এর ভেতরে রাখা উচিত নয়। পূর্ণ AI যোগ করতে backend server ব্যবহার করুন।

## APK বানানোর উপায়
1. কম্পিউটারে Android Studio ইনস্টল করুন।
2. এই project folder Android Studio-তে Open করুন।
3. Gradle sync শেষ হওয়া পর্যন্ত অপেক্ষা করুন।
4. Build > Build Bundle(s) / APK(s) > Build APK(s) নির্বাচন করুন।
5. তৈরি APK ফোনে কপি করে ইনস্টল করুন। ফোনে “Install unknown apps” অনুমতি লাগতে পারে।

## পরীক্ষা
প্রথমে অ্যাপ খুলে Start Hey Jeri চাপুন এবং microphone permission দিন। Notification দেখা উচিত। এরপর “Hey Jeri” বলে দেখুন। Speech recognition ও বাংলা TTS ফোনের সেটিংস অনুযায়ী কাজ করবে।
