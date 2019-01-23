package com.args4j;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.OptionDef;
import org.kohsuke.args4j.spi.*;

import java.util.HashMap;
import java.util.Map;

public class LabelsOptionHandler extends OptionHandler<Map<?,?>> {
        public LabelsOptionHandler(CmdLineParser parser, OptionDef option, Setter<? super Map<?,?>> setter) {
            super(parser, option, setter);
            if (setter.asFieldSetter()==null)
                throw new IllegalArgumentException("MapOptionHandler can only work with fields");
        }

        @Override
        public String getDefaultMetaVariable() {
            return null;
        }

        @Override
        public int parseArguments(Parameters params) throws CmdLineException {
            FieldSetter fs = setter.asFieldSetter();
            Map v = (Map)fs.getValue();
            if (v==null) {
                v = createNewCollection(fs.getType());
                fs.addValue(v);
            }

            addToMap(params.getParameter(0),v);

            return 1;
        }

        /**
         * Creates a new instance of the collection.
         */
        protected Map createNewCollection(Class<? extends Map> type) {
            return new HashMap();
        }

        /**
         * Encapsulates how a single string argument gets converted into key and value.
         */
        protected void addToMap(String argument, Map m) throws CmdLineException {
            if (String.valueOf(argument).indexOf('=') == -1) {
                throw new CmdLineException(owner,Messages.FORMAT_ERROR_FOR_MAP);
            }
            String[] labelArr=argument.split(",",-1);
            for (String arg:labelArr){
                String mapKey;
                String mapValue;
                // Spliting all key value pairs

                //Splitting off the key from the value
                int idx = arg.indexOf('=');
                if (idx>=0) {
                    mapKey = arg.substring(0, idx);
                    mapValue = arg.substring(idx + 1);
                    if (mapValue.length()==0)
                        // Kohsuke: I think this is a bad choice, but this is needed to remain backward compatible
                        mapValue = null;
                } else {
                    mapKey = arg;
                    mapValue = null;
                }

                if (mapKey.length()==0) {
                    throw new CmdLineException(owner,Messages.MAP_HAS_NO_KEY);
                }

                addToMap(m, mapKey, mapValue);

            }
             }

        protected void addToMap(Map m, String key, String value) {
            m.put(key,value);
        }

    }
