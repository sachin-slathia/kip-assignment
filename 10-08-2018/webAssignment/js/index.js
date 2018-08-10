alert("hello");
document.write("hello");
console.log("console");

function function_name(names ,maker) {
	this.names=names;
	this.maker=maker;
}

var obj =new function_name("MotorCycle","Suzuki")
console.log(obj)