package controller;

import model.Ellipse;
import model.interfaces.IApplicationState;
import view.EventName;
import view.interfaces.IUiModule;
import view.mouseHandler;

public class JPaintController implements IJPaintController {
    private final IUiModule uiModule;
    private final IApplicationState applicationState;
    private final mouseHandler mouse;


    public JPaintController(IUiModule uiModule, IApplicationState applicationState, mouseHandler mouse) {
        this.uiModule = uiModule;
        this.applicationState = applicationState;
        this.mouse = mouse;
    }

    @Override
    public void setup() {
        setupEvents();
    }

    private void setupEvents() {
        uiModule.addEvent(EventName.CHOOSE_SHAPE, () -> applicationState.setActiveShape());
        uiModule.addEvent(EventName.CHOOSE_PRIMARY_COLOR, () -> applicationState.setActivePrimaryColor());
        uiModule.addEvent(EventName.CHOOSE_SECONDARY_COLOR, () -> applicationState.setActiveSecondaryColor());
        uiModule.addEvent(EventName.CHOOSE_SHADING_TYPE, () -> applicationState.setActiveShadingType());
        uiModule.addEvent(EventName.CHOOSE_START_POINT_ENDPOINT_MODE, () -> applicationState.setActiveStartAndEndPointMode());
        uiModule.addEvent(EventName.COPY, () -> new CopyCommand(mouse.getSelectedList(),mouse.getClipboard()).run());
        uiModule.addEvent(EventName.PASTE, () -> new PasteCommand(mouse.getClipboard(),mouse.getCanvas(),mouse.getShapeList()).run());
        uiModule.addEvent(EventName.DELETE, () -> new DeleteCommand(mouse.getCanvas(),mouse.getShapeList(),mouse.getSelectedList()).run());
        uiModule.addEvent(EventName.UNDO, () -> new UndoCommand().run());
        uiModule.addEvent(EventName.REDO, () -> new RedoCommand().run());

    }



}
