package {

	import flash.display.Sprite;
	import flash.net.URLLoader;
	import flash.net.URLRequest;
	import flash.events.Event;
	import flash.text.TextField;
	import flash.text.TextFieldAutoSize;
	import flash.text.TextFormat;
	import flash.text.TextFormatAlign;
	import flash.text.TextFieldType;
	import flash.xml.*;

	public class Carica extends Sprite {
		public var elements:Array = new Array();
		public function Carica(chefile) {
			var pathXml:URLRequest = new URLRequest(chefile);
			var loader:URLLoader = new URLLoader();
			loader.addEventListener(Event.COMPLETE, onLoadXML);
			loader.load(pathXml);
		}
		public function onLoadXML(event:Event):void {
			var libraryXml:XML = new XML(event.target.data);
			libraryXml.ignoreWhitespace = true;
			var myDatas:XMLList = libraryXml.elements();
			for (var i:Number = 0; i < myDatas.length(); i++) {
				elements[i] = myDatas[i];
			}
		}
		public function getDati() {
			return elements;
		}
	}
}