package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Type;

public class FloatDeserializer
  implements ObjectDeserializer
{
  public static final FloatDeserializer instance = new FloatDeserializer();

  public static <T> T deserialze(DefaultJSONParser paramDefaultJSONParser)
  {
    JSONLexer localJSONLexer = paramDefaultJSONParser.getLexer();
    if (localJSONLexer.token() == 2)
    {
      paramDefaultJSONParser = localJSONLexer.numberString();
      localJSONLexer.nextToken(16);
      return Float.valueOf(Float.parseFloat(paramDefaultJSONParser));
    }
    if (localJSONLexer.token() == 3)
    {
      float f = localJSONLexer.floatValue();
      localJSONLexer.nextToken(16);
      return Float.valueOf(f);
    }
    paramDefaultJSONParser = paramDefaultJSONParser.parse();
    if (paramDefaultJSONParser == null)
      return null;
    return TypeUtils.castToFloat(paramDefaultJSONParser);
  }

  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    return deserialze(paramDefaultJSONParser);
  }

  public int getFastMatchToken()
  {
    return 2;
  }
}

/* Location:           C:\Users\User\dex2jar-2.0\dex\qting\classes-dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.parser.deserializer.FloatDeserializer
 * JD-Core Version:    0.6.2
 */