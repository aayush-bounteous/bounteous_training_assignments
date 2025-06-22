import { Directive, ElementRef, HostListener, Renderer2 } from "@angular/core";
@Directive({
    selector:'[appHighlight]'
})
export class Highlight{
    constructor(private el: ElementRef, private renderer :Renderer2){
        this.setHighlight('yellow');
    }

    @HostListener('mouseenter') onMouseEnter(){
        this.setHighlight('lightgreen');
    }
     @HostListener('mouseleave') onMouseLeaver(){
        this.setHighlight('yellow');
    }

    private setHighlight(color:String):void{
        this.renderer.setStyle(this.el.nativeElement,'backgroundColor', color);
    }

}