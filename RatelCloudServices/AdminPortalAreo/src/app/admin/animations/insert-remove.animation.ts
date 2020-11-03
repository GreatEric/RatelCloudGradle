import {trigger, animate, transition, style, state} from '@angular/animations';

export const insertRemoveAnimation = trigger('myInsertRemoveTrigger', [
    transition(':enter', [
        animate('.7s', style({ transform: 'translateX(-100%)' }))
    ]),
    transition(':leave', [
        animate('.7s', style({ transform: 'translateX(100%)' }))
    ])
]);