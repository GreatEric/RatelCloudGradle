import {trigger, animate, transition, style, state} from '@angular/animations';

export const openCloseAnimation = trigger('openClose', [
    //style() 函数用来指定一组用作动画的 CSS 样式
    //state() 函数用来定义不同的状态，供每次转场结束时调用
    state('open', style({
        height: '200px',
        opacity: 1,
        backgroundColor: 'yellow'
    })),
    state('closed', style({
        height: '100px',
        opacity: 0.5,
        backgroundColor: 'green'
    })),
    //transition() 接受两个参数：第一个参数接受一个表达式，它定义两个转场状态之间的方向；第二个参数接受一个或一系列 animate() 函数
    //从open状态到closed状态转场
    /*transition('open => closed', [
        //使用 animate() 函数来定义长度、延迟和缓动效果，并指定一个样式函数，以定义转场过程中的样式。 你还可以使用 animate() 函数来为多步动画定义 keyframes() 函数。这些定义放在 animate() 函数的第二个参数中。
        //持续1s
        animate('1s')
    ]),
    //从closed状态到open状态转场
    transition('closed => open', [
        animate('0.5s')
    ]),*/
    //星号 * 或者叫通配符可以匹配任何一个动画状态
    /*transition('* => closed', [
        animate('1s')
    ]),
    transition('* => open', [
        animate('0.5s')
    ]),
    //使用双向箭头语法可以指定任意方向的状态转场。
    transition('open <=> closed', [
        animate('0.5s')
    ]),
    transition ('* => open', [
        animate ('1s',
            style ({ opacity: '*' }),
        ),
    ]),*/
    //当在任意两个状态之间切换时，* => * 转场都会生效。
    transition('* => *', [
        animate('1s')
    ]),
])