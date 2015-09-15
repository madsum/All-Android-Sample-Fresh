#include <jni.h>
#include <android/log.h>


namespace com_masum_test{

    static jint sum_JNI(JNIEnv * env, jclass clazz, jint a, jint b){
        return a + b;
    }

    static jint mul_JNI(JNIEnv * env, jclass clazz, jint a, jint b){
        return a * b;
    }

    static jstring get_string(JNIEnv * env, jclass clazz){
        return (*env).NewStringUTF("Native string");
    }

    static void print_string(JNIEnv * env, jclass clazz, jstring str){
        jboolean isCopy;
        const char* utf_string;
        utf_string = env->GetStringUTFChars(str, &isCopy);
       env->ReleaseStringUTFChars(str, utf_string);
    }

    static JNINativeMethod method_table[] = {
            {"sum_JNI", "(II)I", (void*) sum_JNI},
            {"mul_JNI", "(II)I", (void*) mul_JNI},
            {"get_string","()Ljava/lang/String;", (void*) get_string},
            {"print_string","(Ljava/lang/String;)V", (void*) print_string}
    };

}

using namespace com_masum_test;

extern "C" jint JNI_OnLoad(JavaVM* vm, void* reserved)
{
    JNIEnv* env;
    if (vm->GetEnv(reinterpret_cast<void**>(&env), JNI_VERSION_1_6) != JNI_OK) {
        return -1;
    }
    else
    {
        jclass clazz = env->FindClass("com/masum/myapplication2/JniTest");
        if(clazz)
        {
            env->RegisterNatives(clazz,method_table, sizeof(method_table)/sizeof(method_table[0]));
            env->DeleteLocalRef(clazz);
            return JNI_VERSION_1_6;
        }
        else
        {
            return -1;
        }
    }
    return JNI_VERSION_1_6;
}

