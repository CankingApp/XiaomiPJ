package com.canking.xiaomipj;

import android.accessibilityservice.AccessibilityService;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

import com.canking.xiaomipj.XLogger.XLogger;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by changxing on 16-6-2.
 */
public class BaseAccessService extends AccessibilityService {


    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
    }

    @Override
    public void onInterrupt() {

    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {

    }


    protected boolean clickByText(AccessibilityNodeInfo nodeInfo, String str) {
        if (null != nodeInfo) {
            List<AccessibilityNodeInfo> list = nodeInfo.findAccessibilityNodeInfosByText(str);
            if (null != list && list.size() > 0) {
                AccessibilityNodeInfo node = list.get(list.size() - 1);
                if (node.isClickable()) {
                    return node.performAction(AccessibilityNodeInfo.ACTION_CLICK);
                } else {
                    AccessibilityNodeInfo parentNode = node;
                    for (int i = 0; i < 5; i++) {
                        if (null != parentNode) {
                            parentNode = parentNode.getParent();
                            if (null != parentNode && parentNode.isClickable()) {
                                return parentNode.performAction(AccessibilityNodeInfo.ACTION_CLICK);
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    protected AccessibilityNodeInfo findOpenButton(AccessibilityNodeInfo node) {
        if (node == null)
            return null;

        //非layout元素
        if (node.getChildCount() == 0) {
            if ("android.widget.Button".equals(node.getClassName())) {
                XLogger.t("button").d("find btn ~~~~~~~~~~~~~~~");
                return node;
            } else
                return null;
        }

        //layout元素，遍历找button
        for (int i = 0; i < node.getChildCount(); i++) {
            AccessibilityNodeInfo button = findOpenButton(node.getChild(i));
            if (button != null)
                return button;
        }
        return null;
    }
}
