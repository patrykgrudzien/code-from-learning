package com.jurik99.Adapter;

public class Intro {
	/*
	 *  Adapter design pattern is one of the STRUCTURAL DESIGN PATTERN and its used so that two unrelated interfaces
	 *  can work together. The object that joins these unrelated interfaces is called an ADAPTER.
	 *
	 *  One of the great real life example of Adapter pattern is mobile charger. Mobile baterry needs 3 volts to
	 *  charge but the normal socket produces either 120V (US) or 240V (India). So the mobile charger works as an
	 *  adapter between mobile charging socket and the wall socket.
	 *
	 *  Step-by-step:
	 *  1) 2 classes - Volt, Socket
	 *
	 *  Now we want to build an adapter that can produce 3 volts, 12 volts and default 120 volts. So first of all we
	 *  will create an adapter interface.
	 *  2) SocketAdapter interface
	 *
	 *  TWO WAY ADAPTER PATTERN
	 *  While implementing Adapter pattern, there are two approaches - "class adapter" and "object adapter" - however
	 *  both aproaches produce same result.
	 *
	 *  # CLASS ADAPTER - this form uses "java inheritance" and extends the source interface, in our case Socket class.
	 *  # OBJECT ADAPTER - This form uses "java composition" and adapter contains the source object.
	 *
	 *  3) SocketClassAdapterImpl
	 *  4) SocketObjectAdapterImpl
	 *  5) AdapterPatternTest
	 */
}
