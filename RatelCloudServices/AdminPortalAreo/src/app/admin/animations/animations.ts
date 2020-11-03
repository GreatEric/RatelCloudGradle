import {
    animate,
    group,
    query,
    state,
    style,
    transition,
    trigger
} from '@angular/animations';

export function routerTransition() {
    return trigger('routerAnimation', [
        // LEFT TO RIGHT AKA RESET
        transition('* => 0', [
            // Initial state of new route
            query(':enter',
                style({
                    // "background-position": "center",
                    // transform: "background 0.8s",
                    opacity: 1.0
                }), { optional: true }),
            // move page off screen right on leave
            query(':leave',
                animate('100ms ease',
                    style({
                        // "background-position": "center",
                        // "background-color": "#6eb9f7",
                        // "background-size": "100%",
                        // transition: "background 0s",
                        opacity: 1.0
                    })
                ), { optional: true }),
            // move page in screen from left to right
            query(':enter',
                animate('100ms ease',
                    style({
                        // "background-position": "center",
                        // "background-color": "#6eb9f7",
                        // "background-size": "100%",
                        // transition: "background 0s",
                        opacity: 1.0
                    })
                ), { optional: true }),
        ]),
        // LEFT TO RIGHT AKA PREVIOUS
        transition('* => 1', [
            // Initial state of new route
            query(':enter',
                style({
                    // "background-position": "center",
                    // transform: "background 0.8s",
                    opacity: 1.0
                }), { optional: true }),
            // move page off screen right on leave
            query(':leave',
                animate('100ms ease',
                    style({
                        // "background-position": "center",
                        // "background-color": "#6eb9f7",
                        // "background-size": "100%",
                        // transition: "background 0s",
                        opacity: 1.0
                    })
                ), { optional: true }),
            // move page in screen from left to right
            query(':enter',
                animate('100ms ease',
                    style({
                        // "background-position": "center",
                        // "background-color": "#6eb9f7",
                        // "background-size": "100%",
                        // transition: "background 0s",
                        opacity: 1.0
                    })
                ), { optional: true }),
        ]),
        // RIGHT TO LEFT AKA NEXT
        transition('* => 2', [
            // Initial state of new route
            query(':enter',
                style({
                    // "background-position": "center",
                    // transform: "background 0.8s",
                    opacity: 1.0
                }), { optional: true }),
            // move page off screen right on leave
            query(':leave',
                animate('100ms ease',
                    style({
                        // "background-position": "center",
                        // "background-color": "#6eb9f7",
                        // "background-size": "100%",
                        // transition: "background 0s",
                        opacity: 1.0
                    })
                ), { optional: true }),
            // move page in screen from left to right
            query(':enter',
                animate('100ms ease',
                    style({
                        // "background-position": "center",
                        // "background-color": "#6eb9f7",
                        // "background-size": "100%",
                        // transition: "background 0s",
                        opacity: 1.0
                    })
                ), { optional: true }),
        ])
    ]);
}
