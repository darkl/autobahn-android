/******************************************************************************
 *
 *  Copyright 2011-2012 Tavendo GmbH
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 ******************************************************************************/

package de.tavendo.autobahn;


/**
 * The master thread and the background reader/writer threads communicate
 * using these messages for Autobahn WAMP connections.
 */
public class WampMessage {



   /// Base message class.
   public static class Message extends WebSocketMessage.Message {

   }

   public static class Hello extends Message {
      public String mRealm;
      public HelloDetails mDetails;

      public Hello(String realm, HelloDetails details) {
         mRealm = realm;
         mDetails = details;
      }
   }

   public static class Welcome extends Message {
      public long mSession;
      public WelcomeDetails mDetails;

      public Welcome(long session, WelcomeDetails details) {
         mSession = session;
         mDetails = details;
      }
   }

   public static class Abort extends Message {
      public AbortDetails mDetails;
      public String mReason;

      public Abort(AbortDetails details, String reason) {
         mDetails = details;
         mReason = reason;
      }
   }

   public static class Challenge extends Message {
      public String mAuthMethod;
      public ChallengeExtra mExtra;

      public Challenge(String authMethod, ChallengeExtra extra) {
         mAuthMethod = authMethod;
         mExtra = extra;
      }
   }

   public static class Authenticate extends Message {
      public String mSignature;
      public AuthenticateExtra mExtra;

      public Authenticate(String signature, AuthenticateExtra extra) {
         mSignature = signature;
         mExtra = extra;
      }
   }

   public static class Goodbye extends Message {
      public GoodbyeDetails mDetails;
      public String mReason;

      public Goodbye(GoodbyeDetails details, String reason) {
         mDetails = details;
         mReason = reason;
      }
   }

   public static class Error extends Message {
      public long mType;
      public long mRequest;
      public ErrorDetails mDetails;
      public String mError;
      public Object[] mArgumentsArray;
      public Map<String, Object> mArgumentsKw;

      public Error(long type, long request, ErrorDetails details, String error, Object[] argumentsArray, Map<String, Object> argumentsKw) {
         mType = type;
         mRequest = request;
         mDetails = details;
         mError = error;
         mArgumentsArray = argumentsArray;
         mArgumentsKw = argumentsKw;
      }
   }

   public static class Publish extends Message {
      public long mRequest;
      public PublishOptions mOptions;
      public String mTopic;
      public Object[] mArgumentsArray;
      public Map<String, Object> mArgumentsKw;

      public Publish(long request, PublishOptions options, String topic, Object[] argumentsArray, Map<String, Object> argumentsKw) {
         mRequest = request;
         mOptions = options;
         mTopic = topic;
         mArgumentsArray = argumentsArray;
         mArgumentsKw = argumentsKw;
      }
   }

   public static class Published extends Message {
      public long mRequest;
      public long mPublication;

      public Published(long request, long publication) {
         mRequest = request;
         mPublication = publication;
      }
   }

   public static class Subscribe extends Message {
      public long mRequest;
      public SubscribeOptions mOptions;
      public String mTopic;

      public Subscribe(long request, SubscribeOptions options, String topic) {
         mRequest = request;
         mOptions = options;
         mTopic = topic;
      }
   }

   public static class Subscribed extends Message {
      public long mRequest;
      public long mSubscription;

      public Subscribed(long request, long subscription) {
         mRequest = request;
         mSubscription = subscription;
      }
   }

   public static class Unsubscribe extends Message {
      public long mRequest;
      public long mSubscription;

      public Unsubscribe(long request, long subscription) {
         mRequest = request;
         mSubscription = subscription;
      }
   }

   public static class Unsubscribed extends Message {
      public long mRequest;

      public Unsubscribed(long request) {
         mRequest = request;
      }
   }

   public static class Event extends Message {
      public long mSubscription;
      public long mPublication;
      public EventDetails mDetails;
      public Object[] mArgumentsArray;
      public Map<String, Object> mArgumentsKw;

      public Event(long subscription, long publication, EventDetails details, Object[] argumentsArray, Map<String, Object> argumentsKw) {
         mSubscription = subscription;
         mPublication = publication;
         mDetails = details;
         mArgumentsArray = argumentsArray;
         mArgumentsKw = argumentsKw;
      }
   }

   public static class Call extends Message {
      public long mRequest;
      public CallOptions mOptions;
      public String mProcedure;
      public Object[] mArgumentsArray;
      public Map<String, Object> mArgumentsKw;

      public Call(long request, CallOptions options, String procedure, Object[] argumentsArray, Map<String, Object> argumentsKw) {
         mRequest = request;
         mOptions = options;
         mProcedure = procedure;
         mArgumentsArray = argumentsArray;
         mArgumentsKw = argumentsKw;
      }
   }

   public static class Cancel extends Message {
      public long mRequest;
      public CancelOptions mOptions;

      public Cancel(long request, CancelOptions options) {
         mRequest = request;
         mOptions = options;
      }
   }

   public static class Result extends Message {
      public long mRequest;
      public ResultDetails mDetails;
      public Object[] mArgumentsArray;
      public Map<String, Object> mArgumentsKw;

      public Result(long request, ResultDetails details, Object[] argumentsArray, Map<String, Object> argumentsKw) {
         mRequest = request;
         mDetails = details;
         mArgumentsArray = argumentsArray;
         mArgumentsKw = argumentsKw;
      }
   }

   public static class Register extends Message {
      public long mRequest;
      public RegisterOptions mOptions;
      public String mProcedure;

      public Register(long request, RegisterOptions options, String procedure) {
         mRequest = request;
         mOptions = options;
         mProcedure = procedure;
      }
   }

   public static class Registered extends Message {
      public long mRequest;
      public long mRegistration;

      public Registered(long request, long registration) {
         mRequest = request;
         mRegistration = registration;
      }
   }

   public static class Unregister extends Message {
      public long mRequest;
      public long mRegistration;

      public Unregister(long request, long registration) {
         mRequest = request;
         mRegistration = registration;
      }
   }

   public static class Unregistered extends Message {
      public long mRequest;

      public Unregistered(long request) {
         mRequest = request;
      }
   }

   public static class Invocation extends Message {
      public long mRequest;
      public long mRegistration;
      public InvocationDetails mDetails;
      public Object[] mArgumentsArray;
      public Map<String, Object> mArgumentsKw;

      public Invocation(long request, long registration, InvocationDetails details, Object[] argumentsArray, Map<String, Object> argumentsKw) {
         mRequest = request;
         mRegistration = registration;
         mDetails = details;
         mArgumentsArray = argumentsArray;
         mArgumentsKw = argumentsKw;
      }
   }

   public static class Interrupt extends Message {
      public long mRequest;
      public InterruptOptions mOptions;

      public Interrupt(long request, InterruptOptions options) {
         mRequest = request;
         mOptions = options;
      }
   }

   public static class Yield extends Message {
      public long mRequest;
      public YieldOptions mOptions;
      public Object[] mArgumentsArray;
      public Map<String, Object> mArgumentsKw;

      public Yield(long request, YieldOptions options, Object[] argumentsArray, Map<String, Object> argumentsKw) {
         mRequest = request;
         mOptions = options;
         mArgumentsArray = argumentsArray;
         mArgumentsKw = argumentsKw;
      }
   }
}
