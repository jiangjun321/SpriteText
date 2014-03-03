package com.example.test;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

/**
 * Created by pinguo on 14-2-26.
 */
public class MainActivity extends Activity {

    private static double glVersion = 3.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private static class ContextFactory implements GLSurfaceView.EGLContextFactory {

        private static int EGL_CONTEXT_CLIENT_VERSION = 0x3098;

        @Override
        public EGLContext createContext(EGL10 egl, EGLDisplay display, EGLConfig eglConfig) {

            int[] params = {EGL_CONTEXT_CLIENT_VERSION, (int) glVersion, EGL10.EGL_NONE};
            EGLContext eglContext = egl.eglCreateContext(display, eglConfig, EGL10.EGL_NO_CONTEXT, params);

            return eglContext;
        }

        @Override
        public void destroyContext(EGL10 egl, EGLDisplay display, EGLContext context) {

        }
    }
}
