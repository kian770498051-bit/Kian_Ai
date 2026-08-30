# Kian AI — Android APK project

هذا مشروع Android جاهز للبناء، مع خادم Backend بسيط يحمي مفتاح OpenAI.

## مهم
لا تضع مفتاح `sk-proj-...` داخل التطبيق. ضع `OPENAI_API_KEY` في الخادم فقط.

## بناء APK
افتح المجلد في Android Studio ثم Build > Build APK(s).

## الخادم
داخل `backend`:
1. ثبّت المتطلبات من requirements.txt
2. اضبط متغير البيئة OPENAI_API_KEY
3. شغّل: `uvicorn main:app --host 0.0.0.0 --port 8000`
4. غيّر `BACKEND_URL` في MainActivity.java إلى عنوان `/chat`.

> هذه النسخة هي v1: محادثة نصية. يمكن إضافة الصور وPDF والصوت والذاكرة في الإصدار التالي.
