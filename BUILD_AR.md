# Kian AI — خطوات البناء

## 1) Android Studio
افتح مجلد `KianAI` في Android Studio وانتظر مزامنة Gradle.

## 2) ضبط عنوان الخادم
في:
`app/src/main/java/com/kianai/app/MainActivity.java`
غيّر:
`BACKEND_URL`
إلى عنوان HTTPS لخادمك، مثل:
`https://example.com/chat`

لا تضع مفتاح OpenAI داخل التطبيق.

## 3) تشغيل الخادم
من مجلد `backend`:
- أنشئ متغير البيئة `OPENAI_API_KEY` بمفتاحك السري.
- ثبّت المتطلبات:
`pip install -r requirements.txt`
- شغّل:
`uvicorn main:app --host 0.0.0.0 --port 8000`

للإنتاج استخدم HTTPS واسم نطاق/Reverse Proxy مناسب.

## 4) إخراج APK
في Android Studio:
Build → Build APK(s)

سيظهر APK التطوير عادةً في:
`app/build/outputs/apk/debug/app-debug.apk`

## ملاحظات
هذه النسخة v1 محادثة نصية. يمكن إضافة المصادقة، الصور، PDF، الصوت، والذاكرة في إصدارات لاحقة.
