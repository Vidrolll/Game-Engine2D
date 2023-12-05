package com.gameengine.main.util;

import com.gameengine.main.ui.camera.Camera;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RendererVariables {

    public static final Map<Object, Object> RENDERING_HINTS = new HashMap<>();
    private static final ArrayList<Camera> CAMERAS = new ArrayList<Camera>();
    public static Object ANTIALIASING = RenderingHints.VALUE_ANTIALIAS_DEFAULT;
    public static Object ALPHA_INTERPOLATION = RenderingHints.VALUE_ALPHA_INTERPOLATION_DEFAULT;
    public static Object COLOR_RENDERING = RenderingHints.VALUE_COLOR_RENDER_DEFAULT;
    public static Object DITHERING = RenderingHints.VALUE_DITHER_DEFAULT;
    public static Object FRACTIONAL_METRICS = RenderingHints.VALUE_FRACTIONALMETRICS_DEFAULT;
    public static Object INTERPOLATION = RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR;
    public static Object RENDERING = RenderingHints.VALUE_RENDER_DEFAULT;
    public static Object STROKE_CONTROL = RenderingHints.VALUE_STROKE_DEFAULT;
    public static Object TEXT_ANTIALIASING = RenderingHints.VALUE_TEXT_ANTIALIAS_DEFAULT;
    public static Object TEXT_LCD_CONTRAST = 160;
    private static Camera cam;

    public RendererVariables() {
        cam = new Camera();
        RENDERING_HINTS.put(RenderingHints.KEY_ANTIALIASING, ANTIALIASING);
        RENDERING_HINTS.put(RenderingHints.KEY_ALPHA_INTERPOLATION, ALPHA_INTERPOLATION);
        RENDERING_HINTS.put(RenderingHints.KEY_COLOR_RENDERING, COLOR_RENDERING);
        RENDERING_HINTS.put(RenderingHints.KEY_DITHERING, DITHERING);
        RENDERING_HINTS.put(RenderingHints.KEY_FRACTIONALMETRICS, FRACTIONAL_METRICS);
        RENDERING_HINTS.put(RenderingHints.KEY_INTERPOLATION, INTERPOLATION);
        RENDERING_HINTS.put(RenderingHints.KEY_RENDERING, RENDERING);
        RENDERING_HINTS.put(RenderingHints.KEY_STROKE_CONTROL, STROKE_CONTROL);
        RENDERING_HINTS.put(RenderingHints.KEY_TEXT_ANTIALIASING, TEXT_ANTIALIASING);
        RENDERING_HINTS.put(RenderingHints.KEY_TEXT_LCD_CONTRAST, TEXT_LCD_CONTRAST);
    }

    public void updateHints() {
        //RENDERING_HINTS.clear();
    }

    public static Camera getCam() {
        return cam;
    }

    public static void setCam(int cam) {
        RendererVariables.cam = CAMERAS.get(cam);
    }

    public static void setCam(Camera cam) {
        RendererVariables.cam = cam;
    }

    public static void addCam(Camera cam) {
        CAMERAS.add(cam);
    }
}
