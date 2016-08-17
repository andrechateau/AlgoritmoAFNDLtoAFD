/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import algoritmoafndltoafd.model.AFND;

/**
 *
 * @author Andre Chateaubriand
 */
public class PowersetController {

    private PowersetController() {

    }

    public class PowersetConversion {

        public AFND removeLambda(AFND AFlamda) {
            
            return null;
        }
    }

    public static PowersetController getInstance() {
        return PowersetControllerHolder.INSTANCE;
    }

    private static class PowersetControllerHolder {

        private static final PowersetController INSTANCE = new PowersetController();
    }
}
