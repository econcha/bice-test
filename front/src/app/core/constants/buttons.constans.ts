import { MatProgressButtonOptions } from "mat-progress-buttons";

export const BUTTON_LOAD_INDICATORS: MatProgressButtonOptions = {
    active: false,
    text: 'Spinner Button',
    spinnerSize: 18,
    raised: true,
    fab: true,
    stroked: false,
    buttonColor: 'primary',
    spinnerColor: 'primary',
    fullWidth: false,
    disabled: false,
    mode: 'indeterminate',
    icon: {
      fontIcon: 'insights'
    },
}