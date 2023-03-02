# 🔌 FabricHits
1.16.5 Fabric Hitboxes

# ⚡ How to configure?
- [x] Change Size
- [x] Watermark
- [x] Easily To Configure

Binds:  
I - Reduce The Size Of Hitboxes  
K - Add Size To Hitboxes  
P - Turn ON Panic

Tutorial: [Click](https://www.youtube.com/watch?v=3ZnQzPpPy1o) (in Russian)

# ❓ How it Works?
```java
    @Inject(at = @At("HEAD"), method = "renderEntity", cancellable = true)
    private void renderEntity(Entity entity, double tf, double tf1, double tf2, float tf3, MatrixStack matrixStack,
                              VertexConsumerProvider vertexConsumerProvider, CallbackInfo ci) {
        if (entity instanceof PlayerEntity) {
            if (entity != MinecraftClient.getInstance().player) {
                entity.setBoundingBox(new Box(
                        entity.getX() - (config.isPanic() ? 0.3F : config.getSize()),
                        entity.getBoundingBox().minY,
                        entity.getZ() - (config.isPanic() ? 0.3F : config.getSize()),
                        entity.getX() + (config.isPanic() ? 0.3F : config.getSize()),
                        entity.getBoundingBox().maxY,
                        entity.getZ() + (config.isPanic() ? 0.3F : config.getSize())
                ));
            }
        }
    }

``` 
