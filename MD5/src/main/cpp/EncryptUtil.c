//
// Created by 520 on 2017/3/27.
//

#include <jni.h>
#include <string.h>

JNIEXPORT jstring JNICALL
Java_com_bing_lan_md5_EncryptUtil_encode(JNIEnv *env, jobject instance, jstring orgin, jint length) {
    jstring encrypt;

    char* cstr = (*env)->GetStringUTFChars(env, orgin, 0);

    int i;

    for (i = 0; i < length; i++) {
        cstr[i] += 1;
    }

    encrypt = (*env)->NewStringUTF(env, cstr);

    return encrypt;
}


JNIEXPORT jstring JNICALL
Java_com_bing_lan_md5_EncryptUtil_decode(JNIEnv *env, jobject instance, jstring encrypt, jint length) {
    jstring orgin;
    char *cstr = (*env)->GetStringUTFChars(env, encrypt, 0);

    int i;

    for (i = 0; i < length; i++) {
        cstr[i] -= 1;
    }

    orgin = (*env)->NewStringUTF(env, cstr);
    return orgin;
}