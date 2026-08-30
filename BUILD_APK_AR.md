# بناء Kian AI إلى APK

## 1) Android Studio
افتح مجلد `KianAI`.

## 2) عنوان الخادم
أنشئ ملف `gradle.properties` في جذر المشروع (أو عدّل الموجود) وأضف:
`KIAN_BACKEND_URL=https://YOUR-DOMAIN/chat`

استخدم HTTPS في الإنتاج.

## 3) Backend
من مجلد `backend`:
`pip install -r requirements.txt`
ثم اضبط `OPENAI_API_KEY` على الخادم فقط، وشغّل FastAPI.

## 4) إنشاء APK
من Android Studio:
**Build → Build APK(s)**

لنسخة النشر:
**Build → Generate Signed App Bundle / APK → APK**

لا تضع مفتاح OpenAI داخل ملفات Android أو داخل APK.
