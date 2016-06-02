package com.canking.xiaomipj;

import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

import com.canking.xiaomipj.XLogger.XLogger;

/**
 * Created by changxing on 16-6-1.
 */
public class CxAccessService extends BaseAccessService {
    private boolean end;

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        int eventType = event.getEventType();
        XLogger.v("eventType:" + eventType);

        switch (eventType) {
            case AccessibilityEvent.TYPE_NOTIFICATION_STATE_CHANGED:
                String tip = event.getText().toString();
                XLogger.d("通知栏变更" + tip);
                break;
            case AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED:
                String clazzName = event.getClassName().toString();
                AccessibilityNodeInfo nodeInfo = event.getSource();
                XLogger.i( "悬浮窗：" + clazzName);
                if (clazzName.equals("com.miui.permcenter.permissions.AppPermissionsEditorActivity")) {
                    if (end) {
                        clickByText(nodeInfo, "XiaomiPJ");
                    } else {
                        boolean access = clickByText(nodeInfo, "显示悬浮窗");
                        XLogger.i("access" + access);
                    }
                }
                if (clazzName.equals("miui.app.AlertDialog")) {
                    end = clickByText(nodeInfo, "允许");
                    XLogger.i( "getClick:" + end);
                }
        }
    }

}
