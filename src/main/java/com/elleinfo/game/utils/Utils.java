package com.elleinfo.game.utils;

import com.elleinfo.game.model.CartInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public class Utils {
    private static HashMap<String, String> platformsMap;

    public static HashMap<String, String> getPlatformsMap() {
        if (platformsMap == null) {
            //TODO: get platformsMape from GiantGame
            platformsMap = new HashMap<>();
            platformsMap.put("94", "PC");
            platformsMap.put("87", "Wii");
            platformsMap.put("22", "PlayStation");
        }
        return platformsMap;
    }

    // Products in the cart, stored in Session.
    public static CartInfo getCartInSession(HttpServletRequest request) {

        CartInfo cartInfo = (CartInfo) request.getSession().getAttribute("myCart");


        if (cartInfo == null) {
            cartInfo = new CartInfo();

            request.getSession().setAttribute("myCart", cartInfo);
        }

        return cartInfo;
    }

    public static void removeCartInSession(HttpServletRequest request) {
        request.getSession().removeAttribute("myCart");
    }

    public static void storeLastOrderedCartInSession(HttpServletRequest request, CartInfo cartInfo) {
        request.getSession().setAttribute("lastOrderedCart", cartInfo);
    }

    public static CartInfo getLastOrderedCartInSession(HttpServletRequest request) {
        return (CartInfo) request.getSession().getAttribute("lastOrderedCart");
    }

}
