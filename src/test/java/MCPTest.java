import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import trafficlight.ctrl.TrafficLightCtrl;
import trafficlight.gui.TrafficLight;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class MCPTest {

    @Test
    @DisplayName("Singelton Check 1")
    public void singeltonTest1(){
        TrafficLightCtrl trafficLightCtrl = TrafficLightCtrl.getController();
        assertEquals(trafficLightCtrl, TrafficLightCtrl.getController());
    }

    @Test
    @DisplayName("Next State Check 1")
    public void nextState1(){
        TrafficLightCtrl trafficLightCtrl = TrafficLightCtrl.getController();
        trafficLightCtrl.resetState();
        trafficLightCtrl.nextState();
        assertEquals(trafficLightCtrl.getCurrentState(), trafficLightCtrl.getYellowState());
    }

    @Test
    @DisplayName("Next State Check 2")
    public void nextState2(){
        TrafficLightCtrl trafficLightCtrl = TrafficLightCtrl.getController();
        trafficLightCtrl.resetState();
        trafficLightCtrl.nextState();
        trafficLightCtrl.nextState();
        assertEquals(trafficLightCtrl.getCurrentState(), trafficLightCtrl.getRedState());
    }

    @Test
    @DisplayName("Next State Check 3")
    public void nextState3(){
        TrafficLightCtrl trafficLightCtrl = TrafficLightCtrl.getController();
        trafficLightCtrl.resetState();
        assertEquals(trafficLightCtrl.getCurrentState(), trafficLightCtrl.getGreenState());
    }

    @Test
    @DisplayName("Next State Check 4")
    public void nextState4(){
        TrafficLightCtrl trafficLightCtrl = TrafficLightCtrl.getController();
        trafficLightCtrl.resetState();
        for (int i = 0; i < 20; i++) {
            trafficLightCtrl.nextState();
        }
        assertEquals(trafficLightCtrl.getCurrentState(), trafficLightCtrl.getGreenState());
    }

    @Test
    @DisplayName("Right Traffic Lights at start")
    public void startTrafficLights(){
        TrafficLightCtrl trafficLightCtrl = TrafficLightCtrl.getController();
        trafficLightCtrl.resetState();
        trafficLightCtrl.setStates(trafficLightCtrl.getCurrentState(), trafficLightCtrl.getGreenState());
        assertEquals(trafficLightCtrl.getGreenState(), trafficLightCtrl.getCurrentState());
    }

}