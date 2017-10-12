package ui.controllers;

import ui.views.I_View;

public interface Command {
    public I_View execute();
}
