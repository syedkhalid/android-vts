/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

/**
* @author Vladimir N. Molotkov, Stepan M. Mishura
* @version $Revision$
*/

package android.framework.org.apache.harmony.security_custom.asn1;

import java.io.IOException;


/**
 * This class represents ASN.1 SetOf type.
 *
 * @see <a href="http://asn1.elibel.tm.fr/en/standards/index.htm">ASN.1</a>
 */
public class ASN1SetOf extends ASN1ValueCollection {

    public ASN1SetOf(ASN1Type type) {
        super(TAG_SETOF, type);
    }

    public Object decode(BerInputStream in) throws IOException {
        in.readSetOf(this);

        if (in.isVerify) {
            return null;
        }
        return getDecodedObject(in);
    }

    public final void encodeContent(BerOutputStream out) {
        out.encodeSetOf(this);
    }

    public final void setEncodingContent(BerOutputStream out) {
        out.getSetOfLength(this);
    }
}

