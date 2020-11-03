import {trigger, animate, transition, style, query, animateChild, group, state} from '@angular/animations';
export const swipeAnimation = trigger('swipeAnimations', [
    state('open', style({
        // height: '200px',
        opacity: 1,
        // backgroundColor: 'yellow'
    })),
    state('closed', style({
        //height: '100px',
        opacity: 0.5,
        transform: 'translate3d(-1000px, 0px, 0px)'
        //backgroundColor: 'green'
    })),
    transition('open => closed', [
        animate('1000ms')
    ]),
    transition('closed => open', [
        animate('1000ms')
    ])
]);