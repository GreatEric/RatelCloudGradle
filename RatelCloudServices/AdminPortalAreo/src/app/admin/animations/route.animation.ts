import {trigger, animate, transition, style, group} from '@angular/animations';

export const routeAnimation = trigger('routeAnimations', [
    transition('* <=> *', [
        style({
            opacity: 0
        }),
        group([
            animate('0.5s ease-in', style({
                opacity: 1
            }))
            // animate('0.5s ease-in', style({
            //     transform: 'translateY(100%)'
            // })),
        ])
    ])
]);