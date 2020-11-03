import {trigger, animate, transition, style, state} from '@angular/animations';

export const exterLeaveAnimation = trigger('flyInOut', [
    state('in', style({ transform: 'translateX(0)' })),
    transition('void => *', [
        style({ transform: 'translateX(-100%)' }),
        animate(100)
    ]),
    transition('* => void', [
        animate(100, style({ transform: 'translateX(100%)' }))
    ])
]);